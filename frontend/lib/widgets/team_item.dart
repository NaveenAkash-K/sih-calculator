import 'package:flutter/material.dart';
import 'package:sih_calculator/pages/eval.dart';
import 'package:sih_calculator/utils/shared_preferences.dart';
import 'package:http/http.dart' as http;
import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:sih_calculator/utils/validators.dart';

class TeamItem extends StatelessWidget {
  TeamItem({super.key, required this.category});
  final String category;

  SharedPreferences? prefs = SharedPreferencesManager.preferences;

  @override
  Widget build(BuildContext context) {
    return InkWell(
      splashColor: Theme.of(context).colorScheme.primary.withOpacity(0.2),
      onTap: () {
        Navigator.push(
          context,
          MaterialPageRoute(
            builder: (context) => EvalPage(),
          ),
        );
      },
      child: Ink(
        decoration: BoxDecoration(
          color: Theme.of(context).colorScheme.primaryContainer,
          border: const Border(
            bottom: BorderSide(
              color: Colors.grey,
            ),
          ),
        ),
        padding: EdgeInsets.symmetric(horizontal: 20, vertical: 10),
        child: Row(
          children: [
            Column(
              crossAxisAlignment: CrossAxisAlignment.start,
              children: [
                Text(
                  "Team Name",
                  style: Theme.of(context).textTheme.bodyLarge,
                ),
                Text(
                  "#Team ID",
                  style: Theme.of(context).textTheme.bodyMedium,
                ),
              ],
            ),
          ],
        ),
      ),
    );
  }
}
