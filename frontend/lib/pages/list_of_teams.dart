import 'dart:convert';
import 'package:flutter/material.dart';
import 'package:sih_calculator/utils/shared_preferences.dart';
import 'package:http/http.dart' as http;
import 'package:flutter_dotenv/flutter_dotenv.dart';
import 'package:shared_preferences/shared_preferences.dart';
import 'package:sih_calculator/utils/validators.dart';
import 'package:sih_calculator/widgets/team_item.dart';

class ListOfTeams extends StatefulWidget {
  const ListOfTeams({super.key});

  @override
  State<ListOfTeams> createState() {
    return _ListOfTeamsState();
  }
}

class _ListOfTeamsState extends State<ListOfTeams> {
  SharedPreferences? prefs = SharedPreferencesManager.preferences;
  final TextEditingController searchController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 2,
      child: Scaffold(
        appBar: AppBar(
          title: const Text('Teams'),
          bottom: const TabBar(
            tabs: [
              Tab(text: 'Software'),
              Tab(text: 'Hardware'),
            ],
          ),
        ),
        body: Column(
          children: [
            Padding(
              padding: const EdgeInsets.all(15.0),
              child: TextField(
                onChanged: (value) {
                  
                },
                controller: searchController,
                decoration: InputDecoration(
                  label: Text("Search team"),
                  prefixIcon: Icon(Icons.search),
                  contentPadding: EdgeInsets.symmetric(horizontal: 20),
                  border: OutlineInputBorder(
                    borderRadius: BorderRadius.circular(100),
                  ),
                ),
              ),
            ),
            Expanded(
              child: TabBarView(
                children: [
                  Column(
                    children: [
                      TeamItem(
                        category: "software",
                      ),
                      TeamItem(
                        category: "software",
                      ),
                      TeamItem(
                        category: "software",
                      ),
                    ],
                  ),
                  Column(
                    children: [
                      TeamItem(
                        category: "hardware",
                      ),
                    ],
                  ),
                ],
              ),
            ),
          ],
        ),
      ),
    );
  }
}
