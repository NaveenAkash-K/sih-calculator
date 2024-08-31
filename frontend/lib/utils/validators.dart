bool isEmail(String email) {
  final RegExp emailRegex =
      RegExp(r'^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$');

  return emailRegex.hasMatch(email);
}

bool isPassword(String password) {
  if (password.trim().length > 5) {
    return true;
  }
  return false;
}

bool isPhoneNumber(String phoneNumber) {
  final RegExp phoneRegex = RegExp(r'^[6-9]\d{9}$');
  return phoneRegex.hasMatch(phoneNumber);
}
