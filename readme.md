I made this library with single purpose, to auto format number on the go.
For example:
150000 -> 15,000.
276000800.50 -> 276,000,800.50

While this is easy to achieve using simple format, I find it challenging when you involve user interaction (on EditText), especially after inserting or deleting a text. With this library user can type money on EditText without worrying it will not incorrectly formatted.

Feature:
- Thousands separated number auto-format
- Value after dots will not be formatted i.e  732,000.502816
- Support with or without decimal formatting
- Various input restriction (Soft input keyboard and max length)

You may find this library useful for:
- Calculator app
- Banking / Finance app
- Any app that involve auto formatting

Demo:
// TODO:YouTube link here

Usage:
add this on your gradle
compile 'com.aldoapps:autoformatedittext:0.9.1'
