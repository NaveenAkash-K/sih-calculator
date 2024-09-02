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
            title: Text("Evaluation"),
            bottom: const TabBar(
              tabs: [
                Tab(text: 'Round 1'),
                Tab(text: 'Round 2'),
                Tab(text: 'Round 3'),
              ],
            ),
          ),
          body: const TabBarView(
            children: [
              Column(),
              Column(),
              Column(),
            ],
          ),
        ));
  }
}
