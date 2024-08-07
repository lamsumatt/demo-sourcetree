import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QPushButton, QVBoxLayout, QHBoxLayout, QWidget, QLineEdit
from PyQt5.QtCore import Qt

class CalculatorApp(QMainWindow):
    def __init__(self):
        super().__init__()

        # Set the window properties (title and initial size)
        self.setWindowTitle("Basic Calculator")
        self.setGeometry(100, 100, 400, 400)  # (x, y, width, height)

        # Create a central widget for the main window
        central_widget = QWidget()
        self.setCentralWidget(central_widget)

        # Create a QLineEdit widget for input and result display
        self.input_display = QLineEdit()
        self.input_display.setAlignment(Qt.AlignmentFlag.AlignRight)
        self.input_display.setReadOnly(True)

        # Create a layout for buttons
        main_layout = QVBoxLayout()

        # Create number and special buttons (0, ., =) on the same row
        number_special_buttons_layout = QHBoxLayout()
        for i in range(1, 4):
            number_button = QPushButton(str(i))
            number_button.clicked.connect(lambda checked, ch=i: self.on_number_button_click(ch))
            number_special_buttons_layout.addWidget(number_button)

        for i in range(4, 7):
            number_button = QPushButton(str(i))
            number_button.clicked.connect(lambda checked, ch=i: self.on_number_button_click(ch))
            number_special_buttons_layout.addWidget(number_button)

        for i in range(7, 10):
            number_button = QPushButton(str(i))
            number_button.clicked.connect(lambda checked, ch=i: self.on_number_button_click(ch))
            number_special_buttons_layout.addWidget(number_button)

        # Add special buttons (0, ., =)
        zero_button = QPushButton("0")
        zero_button.clicked.connect(lambda: self.on_number_button_click(0))
        number_special_buttons_layout.addWidget(zero_button)

        dot_button = QPushButton(".")
        dot_button.clicked.connect(self.on_dot_button_click)
        number_special_buttons_layout.addWidget(dot_button)

        equals_button = QPushButton("=")
        equals_button.clicked.connect(self.calculate_result)
        number_special_buttons_layout.addWidget(equals_button)

        # Create operator buttons in a vertical layout
        operator_buttons_layout = QVBoxLayout()
        operators = ["+", "-", "*", "/"]
        for operator in operators:
            operator_button = QPushButton(operator)
            operator_button.clicked.connect(lambda checked, ch=operator: self.on_operator_button_click(ch))
            operator_buttons_layout.addWidget(operator_button)

        # Add layouts to the main layout
        main_layout.addWidget(self.input_display)
        main_layout.addLayout(number_special_buttons_layout)
        main_layout.addLayout(operator_buttons_layout)

        # Set the layout for the central widget
        central_widget.setLayout(main_layout)

        # Initialize the input expression
        self.input_expression = ""

    def on_number_button_click(self, digit):
        self.input_expression += str(digit)
        self.update_input_display()

    def on_dot_button_click(self):
        if "." not in self.input_expression:
            self.input_expression += "."
            self.update_input_display()

    def on_operator_button_click(self, operator):
        if self.input_expression and self.input_expression[-1] not in "+-*/":
            self.input_expression += operator
            self.update_input_display()

    def calculate_result(self):
        try:
            result = eval(self.input_expression)
            self.input_expression = str(result)
            self.update_input_display()
        except Exception as e:
            self.input_expression = "err"
            self.update_input_display()

    def update_input_display(self):
        self.input_display.setText(self.input_expression)
    
def main():
    app = QApplication(sys.argv)
    window = CalculatorApp()
    window.show()
    sys.exit(app.exec_())

if __name__ == '__main__':
    main()
