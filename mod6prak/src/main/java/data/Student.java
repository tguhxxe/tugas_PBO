package data;


import books.Book;
import exception.custom.IllegalAdminAccess;
import util.iMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Student extends User implements iMenu {
    public static ArrayList<UserStudent> arr_userStudent = new ArrayList<>();
    public static class UserStudent {
        String nama, nim, fakultas, prodi;

        public UserStudent(String nama, String nim, String fakultas, String prodi) {
            this.nama = nama;
            this.nim = nim;
            this.fakultas = fakultas;
            this.prodi = prodi;
        }
    }

    @Override
    public void menu() {
        Stage studentMenuStage = new Stage();
        studentMenuStage.setTitle("Lib UMM - Menu Student");

        //Label
        Label sceneTitle = new Label("Menu Student");

        //Font style
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20 ));

        //Font color
        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");

        //Button
        Button borrowedBookButton = new Button("Buku Terpinjam");
        Button borrowBookButton   = new Button("Pinjam Buku");
        Button returnBookButton   = new Button("Kembalikan Buku");

        //Grid layout
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(sceneTitle, 0,1);

        grid.add(borrowedBookButton, 2,1);
        grid.add(borrowBookButton, 2,2);
        grid.add(returnBookButton,2,3);

        grid.setVgap(10);
        grid.setHgap(5);

        Scene studentmenuScene = new Scene(grid, 1360, 720);
        studentMenuStage.setScene(studentmenuScene);
        studentMenuStage.show();

        //Action button
        borrowedBookButton.setOnAction(event ->{
            showBorrowedBooks();
            studentMenuStage.close();
        });

        borrowBookButton.setOnAction(event -> {
            choiceBooks();
            studentMenuStage.close();
        });

        returnBookButton.setOnAction(event ->{
            returnBooks();
            studentMenuStage.close();
        });

    }

    @Override
    public void choiceBooks(){
        super.choiceBooks();
    }
    public static void showBorrowedBooks(){
        Stage showBorrowedBooksStage = new Stage();
        showBorrowedBooksStage.setTitle("Informasi Buku Yang Dipinjam");

        TableView<Book> table = new TableView<>();
        table.setPrefSize(1360, 720);

        TableColumn<Book, String> idColumn = new TableColumn<>("ID Buku");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));

        TableColumn<Book, String> titleColumn = new TableColumn<>("Nama Buku");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));

        TableColumn<Book, String> authorColumn = new TableColumn<>("Penulis");
        authorColumn.setCellValueFactory(new PropertyValueFactory<>("author"));

        TableColumn<Book, String> categoryColumn = new TableColumn<>("Kategori");
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));

        TableColumn<Book, Integer> durationColumn = new TableColumn<>("Durasi");
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        table.getColumns().add(idColumn);
        table.getColumns().add(titleColumn);
        table.getColumns().add(authorColumn);
        table.getColumns().add(categoryColumn);
        table.getColumns().add(durationColumn);

        for (Book a : Book.arr_borrowedBook) {
            for (Book i : Book.arr_bookList) {
                if (i.getBookId().equals(a.getBookId())) {
                    table.getItems().add(i);
                }
            }
        }


        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(table, 0, 0);

        gridPane.setVgap(10);
        gridPane.setHgap(5);

        Scene scene = new Scene(gridPane,840,700);
        showBorrowedBooksStage.setScene(scene);
        showBorrowedBooksStage.show();

    }

    public static void returnBooks(){

        Stage returnBooksStage = new Stage();
        returnBooksStage.setTitle("UMM Library - Pengembalian buku");

        //Label
        Label headerTitle = new Label("Pengembalian buku");
        Label bookIdLabel = new Label("Inputkan ID buku yang ingin dikembalikan");

        //Notification Label
        Label submitSuccesLabel = new Label("Pengembalian berhasil");
        Label submitFailedLabel = new Label("Pengembalian gagal");

        //Font Style
        headerTitle.setFont(Font.font("Tahoma", FontWeight.BOLD, 20));
        bookIdLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));

        //Font Color
        headerTitle.setStyle("-fx-text-fill: #A91D3A;");
        submitSuccesLabel.setStyle("-fx-text-fill: #16FF00;");
        submitFailedLabel.setStyle("-fx-text-fill: #FF1E1E;");

        //Notification label settings
        submitSuccesLabel.setVisible(false);
        submitFailedLabel.setVisible(false);
        
        //Field
        TextField bookIdField = new TextField();



        //Button
        Button submitButton = new Button("Kembalikan");
        Button returnButton = new Button("Kembali");

        //Table label
        TableView<Book> tableView  = new TableView<>();

        TableColumn<Book, String> idBookColumn     = new TableColumn<>("ID Buku");
        TableColumn<Book, String> titleBookColumn = new TableColumn<>("Judul");
        TableColumn<Book, String> authorBookColumn = new TableColumn<>("Author");
        TableColumn<Book, String> categoryBookColumn = new TableColumn<>("Kategori");
        TableColumn<Book, String> durationBookColumn = new TableColumn<>("Durasi Pinjaman (Hari)");

        //Table fill
        idBookColumn.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleBookColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorBookColumn.setCellValueFactory(new PropertyValueFactory<>("author"));
        categoryBookColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
        durationBookColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));

        for(Book i : Book.arr_borrowedBook ){
            tableView.getItems().add(i);
        }


        //Grid layout
        GridPane grid = new GridPane();

        grid.setAlignment(Pos.CENTER);

        grid.add(headerTitle,2,0);
        grid.add(tableView, 0,1);

        grid.add(bookIdLabel,0,2);
        grid.add(bookIdField, 0,3);

        grid.add(submitSuccesLabel,5,2);
        grid.add(submitFailedLabel,5,2);

        grid.add(submitButton, 4,4);
        grid.add(returnButton, 0,4);

        Scene returnBookScene = new Scene(grid, 840,700);
        returnBooksStage.setScene(returnBookScene);
        returnBooksStage.show();

        submitButton.setOnAction(event ->{

            boolean validasiReturnBooks = false;

            for (int i = 0; i < Book.arr_borrowedBook.size(); i++ ) {


                if (Book.arr_borrowedBook.get(i).getBookId().equals(bookIdField.getText())) {
                    for (Book book : Book.arr_bookList) {
                        if (book.getBookId().equals(bookIdField.getText())) {

                            int returnBook = book.getStock();
                            returnBook++;
                            book.setStock(returnBook);

                            Book.arr_borrowedBook.remove(i);

                            validasiReturnBooks = true;
                        }
                    }
                }
            }
            tableView.refresh();
            if(validasiReturnBooks){
                submitSuccesLabel.setVisible(true);
                submitFailedLabel.setVisible(false);

            }else{
                submitFailedLabel.setVisible(true);
                submitSuccesLabel.setVisible(false);
            }
        });

        returnButton.setOnAction(event ->{
            Student studentObj = new Student();

            studentObj.menu();
            returnBooksStage.close();

        });



    }


    public boolean isStudents(TextField username) throws IllegalAdminAccess {
        if (username.getText().length() != 15) {
            throw new IllegalAdminAccess("NIM harus 15 digit!");
        }
        for (UserStudent i : arr_userStudent) {
            if (i.nim.equals(username.getText())) {
                menu();
                return false;
            }
        }
        throw new IllegalAdminAccess("NIM tidak ditemukan!");
    }
}

