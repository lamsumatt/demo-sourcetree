import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QPushButton, QColorDialog, QFontDialog, QVBoxLayout, QWidget

class WidgetPropertiesApp(QMainWindow):
    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        self.setWindowTitle("Widget Properties App")
        self.setGeometry(100, 100, 400, 300)

        central_widget = QWidget()
        layout = QVBoxLayout(central_widget)

        # Create QPushButton
        self.button = QPushButton("Customize Me", self)
        layout.addWidget(self.button)

        # Create buttons for customization
        color_button = QPushButton("Change Color", self)
        color_button.clicked.connect(self.customize_color)
        layout.addWidget(color_button)

        font_button = QPushButton("Change Font", self)
        font_button.clicked.connect(self.customize_font)
        layout.addWidget(font_button)

        self.setCentralWidget(central_widget)

    def customize_color(self):
        color = QColorDialog.getColor()
        if color.isValid():
            self.button.setStyleSheet(f"background-color: {color.name()}")

    def customize_font(self):
        font, ok = QFontDialog.getFont()
        if ok:
            self.button.setFont(font)

def main():
    app = QApplication(sys.argv)
    main_window = WidgetPropertiesApp()
    main_window.show()
    sys.exit(app.exec_())

if __name__ == "__main__":
    main()
