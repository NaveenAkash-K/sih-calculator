import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:fluttertoast/fluttertoast.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:sih_calculator/utils/shared_preferences.dart';

class Parameters extends ConsumerStatefulWidget {
  const Parameters({Key? key}) : super(key: key);

  @override
  ConsumerState<Parameters> createState() {
    return _ParametersState();
  }
}

class _ParametersState extends ConsumerState<Parameters> {
  final GlobalKey<FormState> _formKey = GlobalKey<FormState>();
  final TextEditingController _titleController = TextEditingController();
  final TextEditingController _messageController = TextEditingController();
  bool isLoading = false;
  late FToast toast;

  @override
  Widget build(BuildContext context) {
    SharedPreferences? prefs = SharedPreferencesManager.preferences;
    toast = FToast();
    toast.init(context);
    ColorScheme colorScheme = Theme.of(context).colorScheme;
    TextTheme textTheme = Theme.of(context).textTheme;

    return Scaffold(
      appBar: AppBar(
        title: const Text("Evaluation Parameters"),
      ),
      body: Padding(
        padding: const EdgeInsets.symmetric(vertical: 12, horizontal: 20),
        child: Column(
          crossAxisAlignment: CrossAxisAlignment.start,
          children: [
            Form(
              key: _formKey,
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  TextFormField(
                    controller: _titleController,
                    decoration: const InputDecoration(
                      labelText: "Title",
                      floatingLabelBehavior: FloatingLabelBehavior.always,
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.all(Radius.circular(8)),
                      ),
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Please enter the title';
                      }
                      return null;
                    },
                  ),
                  const SizedBox(height: 20),
                  TextFormField(
                    controller: _messageController,
                    keyboardType: TextInputType.number,
                    decoration: const InputDecoration(
                      labelText: "Max marks",
                      floatingLabelBehavior: FloatingLabelBehavior.always,
                      border: OutlineInputBorder(
                        borderRadius: BorderRadius.all(Radius.circular(8)),
                      ),
                    ),
                    validator: (value) {
                      if (value == null || value.isEmpty) {
                        return 'Please enter the message';
                      }
                      final marks = num.tryParse(value);
                      if (marks == null) {
                        return "Please enter a valid number";
                      }
                      return null;
                    },
                    maxLines: null,
                  ),
                  const SizedBox(height: 20),
                  InkWell(
                    onTap: isLoading ? null : _submitForm,
                    child: Ink(
                      width: double.infinity,
                      padding: const EdgeInsets.symmetric(
                        vertical: 18,
                        horizontal: 20,
                      ),
                      decoration: BoxDecoration(
                        color: const Color.fromARGB(255, 1, 46, 76),
                        borderRadius: BorderRadius.circular(8),
                      ),
                      child: isLoading
                          ? Column(
                              children: [
                                CircularProgressIndicator(
                                  color: colorScheme.background,
                                ),
                              ],
                            )
                          : Text(
                              "Add Parameter",
                              textAlign: TextAlign.center,
                              style: textTheme.bodyLarge!.copyWith(
                                fontWeight: FontWeight.bold,
                                color: Colors.white,
                              ),
                            ),
                    ),
                  ),
                ],
              ),
            ),
            const SizedBox(
              height: 20,
            ),
            const Text(
              "Current Announcement(s)",
              style: TextStyle(
                fontWeight: FontWeight.bold,
                fontSize: 18,
              ),
            ),
            // Expanded(
            //   child: ListView.builder(
            //     itemCount: announcements!.length,
            //     itemBuilder: (context, index) {
            //       final announcement = announcements![index];
            //       return Column(
            //         crossAxisAlignment: CrossAxisAlignment.start,
            //         children: [
            //           ListTile(
            //             title: Text(
            //               announcement.title,
            //               style: const TextStyle(
            //                   fontSize: 16, fontWeight: FontWeight.bold),
            //             ),
            //             subtitle: Text(announcement.message),
            //             trailing: IconButton(
            //               icon: Icon(
            //                 Icons.delete,
            //                 color: Theme.of(context).colorScheme.error,
            //               ),
            //               onPressed: () async {
            //                 setState(() {
            //                   isLoading = true;
            //                 });
            //                 await ref
            //                     .read(rtAnnouncementNotifier.notifier)
            //                     .deleteAnnouncement(
            //                       announcementId: announcement.announcementId,
            //                     );
            //                 toast.removeQueuedCustomToasts();

            //                 toast.showToast(
            //                   child: ToastMsg(
            //                     text: "Announcement Deleted",
            //                     bgColor: Theme.of(context)
            //                         .colorScheme
            //                         .errorContainer,
            //                   ),
            //                 );

            //                 setState(() {
            //                   isLoading = false;
            //                 });
            //               },
            //             ),
            //           ),
            //         ],
            //       );
            //     },
            //   ),
            // ),
          ],
        ),
      ),
    );
  }

  void _submitForm() {}
}
