import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QLineEdit, QPushButton, QLabel, QVBoxLayout, QWidget

class TextDisplayApp(QMainWindow):
    def __init__(self):
        super().__init__()

        self.initUI()

    def initUI(self):
        # Set window properties
        self.setWindowTitle("Text Display App")
        self.setGeometry(100, 100, 400, 200)

        # Create central widget and layout
        central_widget = QWidget()
        layout = QVBoxLayout(central_widget)

        # Create QLineEdit
        self.line_edit = QLineEdit(self)
        layout.addWidget(self.line_edit)

        # Create QPushButton
        self.button = QPushButton("Display Text", self)
        self.button.clicked.connect(self.display_text)
        layout.addWidget(self.button)

        # Create QLabel
        self.label = QLabel(self)
        layout.addWidget(self.label)

        # Set central widget
        self.setCentralWidget(central_widget)

    def display_text(self):
        # Retrieve text from QLineEdit and display it in QLabel
        text = self.line_edit.text()
        self.label.setText(text)

def main():
    app = QApplication(sys.argv)
    main_window = TextDisplayApp()
    main_window.show()
    sys.exit(app.exec_())

if __name__ == "__main__":
    main()
