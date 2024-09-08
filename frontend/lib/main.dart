import 'package:flutter/material.dart';
import 'package:google_fonts/google_fonts.dart';
import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';
import 'package:sih_calculator/pages/list_of_teams.dart';
import 'package:sih_calculator/pages/login.dart';
import 'package:sih_calculator/utils/shared_preferences.dart';

final theme = ThemeData(
  colorScheme: ColorScheme.fromSeed(
    seedColor: const Color.fromARGB(255, 153, 0, 255),
  ),
  textTheme: GoogleFonts.interTextTheme(),
);

void main() async {
  WidgetsFlutterBinding.ensureInitialized();
  await SharedPreferencesManager.init();
  await dotenv.load();
  runApp(
    const ProviderScope(child: App()),
  );
}

class App extends StatelessWidget {
  const App({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      theme: theme,
      home: const ListOfTeams(),
    );
  }
}
