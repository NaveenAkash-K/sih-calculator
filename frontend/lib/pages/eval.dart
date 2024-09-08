import 'package:flutter/material.dart';

class EvalPage extends StatefulWidget {
  const EvalPage({super.key});

  @override
  State<EvalPage> createState() => _EvalPageState();
}

class _EvalPageState extends State<EvalPage> {
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
        length: 3,
        child: Scaffold(
          appBar: AppBar(
            title: const Text("Evaluation"),
            bottom: const TabBar(
              tabs: [
                Tab(text: 'Round 1'),
                Tab(text: 'Round 2'),
                Tab(text: 'Round 3'),
              ],
            ),
          ),
          body: Padding(
            padding: const EdgeInsets.all(10),
            child: TabBarView(
              children: [
                Column(
                  children: [
                    Row(
                      children: [
                        const Spacer(),
                        Text(
                          "Parameter 2: ",
                          style: Theme.of(context)
                              .textTheme
                              .bodyLarge!
                              .copyWith(fontWeight: FontWeight.bold),
                        ),
                        const Expanded(
                          child: Padding(
                            padding: EdgeInsets.all(8.0),
                            child: TextField(
                              decoration: InputDecoration(
                                border: OutlineInputBorder(),
                                contentPadding:
                                    EdgeInsets.symmetric(horizontal: 20),
                              ),
                            ),
                          ),
                        ),
                        // Spacer(),
                        const Spacer(),
                      ],
                    ),
                    Row(
                      children: [
                        const Spacer(),
                        Text(
                          "Parameter 2: ",
                          style: Theme.of(context)
                              .textTheme
                              .bodyLarge!
                              .copyWith(fontWeight: FontWeight.bold),
                        ),
                        const Expanded(
                          child: Padding(
                            padding: EdgeInsets.all(8.0),
                            child: TextField(
                              decoration: InputDecoration(
                                border: OutlineInputBorder(),
                                contentPadding:
                                    EdgeInsets.symmetric(horizontal: 20),
                              ),
                            ),
                          ),
                        ),
                        // Spacer(),
                        const Spacer(),
                      ],
                    ),
                  ],
                ),
                Column(
                  children: [
                    Table(
                      border: TableBorder.all(),
                      defaultVerticalAlignment:
                          TableCellVerticalAlignment.middle,
                      columnWidths: const {
                        0: FractionColumnWidth(0.4),
                        1: FractionColumnWidth(0.2),
                        2: FractionColumnWidth(0.2)
                      },
                      children: [
                        TableRow(
                          children: [
                            Text(
                              "Parameters",
                              style: Theme.of(context)
                                  .textTheme
                                  .bodyLarge!
                                  .copyWith(fontWeight: FontWeight.bold),
                              textAlign: TextAlign.center,
                            ),
                            Text(
                              "Max Marks",
                              style: Theme.of(context)
                                  .textTheme
                                  .bodyLarge!
                                  .copyWith(fontWeight: FontWeight.bold),
                              textAlign: TextAlign.center,
                            ),
                            Text(
                              "Total Marks",
                              style: Theme.of(context)
                                  .textTheme
                                  .bodyLarge!
                                  .copyWith(fontWeight: FontWeight.bold),
                              textAlign: TextAlign.center,
                            ),
                          ],
                        ),
                        TableRow(
                          children: [
                            Text(
                              "Parameter 1",
                              textAlign: TextAlign.center,
                              style: Theme.of(context)
                                  .textTheme
                                  .bodyLarge!
                                  .copyWith(fontWeight: FontWeight.bold),
                            ),
                            Text(
                              "10",
                              textAlign: TextAlign.center,
                              style: Theme.of(context)
                                  .textTheme
                                  .bodyLarge!
                                  .copyWith(fontWeight: FontWeight.bold),
                            ),
                            const TextField(
                              textAlign: TextAlign.center,
                            ),
                          ],
                        ),
                        TableRow(
                          children: [
                            Text(
                              "Parameter 2",
                              textAlign: TextAlign.center,
                              style: Theme.of(context)
                                  .textTheme
                                  .bodyLarge!
                                  .copyWith(fontWeight: FontWeight.bold),
                            ),
                            Text(
                              "10",
                              textAlign: TextAlign.center,
                              style: Theme.of(context)
                                  .textTheme
                                  .bodyLarge!
                                  .copyWith(fontWeight: FontWeight.bold),
                            ),
                            const Center(
                              child: TextField(
                                decoration: InputDecoration(
                                  floatingLabelBehavior:
                                      FloatingLabelBehavior.never,
                                ),
                                textAlign: TextAlign.center,
                              ),
                            ),
                          ],
                        ),
                        TableRow(
                          children: [
                            Text(
                              "Parameter 3",
                              textAlign: TextAlign.center,
                              style: Theme.of(context)
                                  .textTheme
                                  .bodyLarge!
                                  .copyWith(fontWeight: FontWeight.bold),
                            ),
                            Text(
                              "10",
                              textAlign: TextAlign.center,
                              style: Theme.of(context)
                                  .textTheme
                                  .bodyLarge!
                                  .copyWith(fontWeight: FontWeight.bold),
                            ),
                            const TextField(
                              textAlign: TextAlign.center,
                            ),
                          ],
                        ),
                      ],
                    ),
                    ElevatedButton(
                      onPressed: () {},
                      style: ElevatedButton.styleFrom(
                          backgroundColor:
                              Theme.of(context).colorScheme.primary,
                          foregroundColor: Colors.white),
                      child: const Text("Submit"),
                    )
                  ],
                ),
                const Column(),
              ],
            ),
          ),
        ));
  }
}
