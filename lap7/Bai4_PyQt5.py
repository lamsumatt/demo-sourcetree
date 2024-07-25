import sys
from PyQt5.QtWidgets import QApplication, QMainWindow, QPushButton, QDialog, QLabel, QVBoxLayout, QWidget

class MyWindow(QMainWindow):
    def __init__(self):
        super().__init__()
        self.initUI()

    def initUI(self):
        self.setWindowTitle("Dialog Example")
        self.setGeometry(100, 100, 400, 300)

        central_widget = QWidget()
        self.setCentralWidget(central_widget)
        layout = QVBoxLayout(central_widget)

        self.dialog_button = QPushButton("Hiển thị hộp thoại", self)
        self.dialog_button.clicked.connect(self.show_dialog)
        layout.addWidget(self.dialog_button)

    def show_dialog(self):
        dialog = QDialog(self)
        dialog.setWindowTitle("Hộp thoại")

        label = QLabel("Đây là thông báo trong hộp thoại.", dialog)
        
        dialog_layout = QVBoxLayout()
        dialog_layout.addWidget(label)
        
        dialog.setLayout(dialog_layout)
        
        dialog.exec_()

def main():
    app = QApplication(sys.argv)
    main_window = MyWindow()
    main_window.show()
    sys.exit(app.exec_())

if __name__ == "__main__":
    main()
