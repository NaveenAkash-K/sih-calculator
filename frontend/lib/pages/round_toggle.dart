import 'package:flutter/material.dart';

class HackathonRoundsTogglePage extends StatefulWidget {
  const HackathonRoundsTogglePage({super.key});

  @override
  _HackathonRoundsTogglePageState createState() =>
      _HackathonRoundsTogglePageState();
}

class _HackathonRoundsTogglePageState extends State<HackathonRoundsTogglePage> {
  final List<bool> _roundsActive = [false, false, false];

  Future<void> _toggleRound(int round) async {
    setState(() {
      _roundsActive[round] = !_roundsActive[round];
    });

    final isActive = _roundsActive[round];
    final roundNumber = round + 1;

    print('Round $roundNumber is now ${isActive ? "active" : "inactive"}');
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Toggle Rounds'),
      ),
      body: ListView.builder(
        itemCount: 3,
        itemBuilder: (context, index) {
          return ListTile(
            title: Text('Round ${index + 1}'),
            trailing: Switch(
              value: _roundsActive[index],
              onChanged: (bool value) {
                _toggleRound(index);
              },
            ),
          );
        },
      ),
    );
  }
}
