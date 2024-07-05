package com.main;

import data.Admin;
import data.Student;
import exception.custom.IllegalAdminAccess;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class LibrarySystem extends Application {

    public static String NIM;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Admin adminObj = new Admin();
        Student studentObj = new Student();

        primaryStage.setTitle("Lib UMM");

        String imagePath = "file:///C:/Users/asus tuf/Downloads/logo_umm-removebg-preview.png";

        Image appIcon = new Image(imagePath);
        primaryStage.getIcons().add(appIcon);

        ImageView imageView = new ImageView(appIcon);
        imageView.setFitWidth(290);
        imageView.setPreserveRatio(true);


        Label sceneTitle = new Label("Perpustakaan");
        Label usernameLabel = new Label("Username");
        Label passwordLabel = new Label("Password");

        Label errorLoginMessage = new Label("Pengguna tidak ditemukan");

        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();

        sceneTitle.setFont(Font.font("Poppins", FontWeight.BOLD, 45));
        usernameLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        passwordLabel.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 15));
        errorLoginMessage.setFont(Font.font("Calibri Body", FontWeight.NORMAL, 12));

        sceneTitle.setStyle("-fx-text-fill: #A91D3A;");
        errorLoginMessage.setStyle("-fx-text-fill: #FF1E1E;");

        errorLoginMessage.setVisible(false);

        Button loginButton = new Button("Login");


        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        grid.add(imageView, 0, 0, 2, 1);
        grid.add(sceneTitle, 0, 1, 2, 1);

        grid.add(usernameLabel, 0, 2);
        grid.add(passwordLabel, 0, 3);
        grid.add(errorLoginMessage, 0, 4);

        grid.add(usernameField, 1, 2);
        grid.add(passwordField, 1, 3);

        grid.add(loginButton, 1, 4);

        grid.setVgap(10);
        grid.setHgap(5);

        Scene scene = new Scene(grid, 820, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

        loginButton.setOnAction(event -> handleLogin(usernameField, passwordField, errorLoginMessage, adminObj, studentObj, primaryStage));

        usernameField.setOnAction(event -> passwordField.requestFocus());

        passwordField.setOnAction(event -> handleLogin(usernameField, passwordField, errorLoginMessage, adminObj, studentObj, primaryStage));
    }

    private void handleLogin(TextField usernameField, PasswordField passwordField, Label errorLoginMessage, Admin adminObj, Student studentObj, Stage primaryStage) {
        if (usernameField.getText().equals(Admin.adminusername) && passwordField.getText().equals(Admin.adminpassword)) {
            adminObj.menu();
            primaryStage.close();
        } else if (usernameField.getText().length() == 15 && passwordField.getText().length() < 15) {
            try {
                if (studentObj.isStudents(usernameField)) {
                    errorLoginMessage.setVisible(false);
                    studentObj.isStudents(usernameField);
                } else {
                    errorLoginMessage.setVisible(true);
                }
            } catch (IllegalAdminAccess pesanError) {
                errorLoginMessage.setText(pesanError.getMessage());
                errorLoginMessage.setVisible(true);
            }
        } else {
            errorLoginMessage.setVisible(true);
        }
    }
}
 // Ini adalah program sederhana dengan banyak komentar

        /*
         * Ini adalah komentar multi-baris yang akan memenuhi beberapa baris.
         * Kita bisa menggunakan ini untuk menambahkan banyak komentar di dalam
         * file ini.
         */
        
        // Baris 1
        // Baris 2
        // Baris 3
        // Baris 4
        // Baris 5
        // Baris 6
        // Baris 7
        // Baris 8
        // Baris 9
        // Baris 10
        // Baris 11
        // Baris 12
        // Baris 13
        // Baris 14
        // Baris 15
        // Baris 16
        // Baris 17
        // Baris 18
        // Baris 19
        // Baris 20
        // Baris 21
        // Baris 22
        // Baris 23
        // Baris 24
        // Baris 25
        // Baris 26
        // Baris 27
        // Baris 28
        // Baris 29
        // Baris 30
        // Baris 31
        // Baris 32
        // Baris 33
        // Baris 34
        // Baris 35
        // Baris 36
        // Baris 37
        // Baris 38
        // Baris 39
        // Baris 40
        // Baris 41
        // Baris 42
        // Baris 43
        // Baris 44
        // Baris 45
        // Baris 46
        // Baris 47
        // Baris 48
        // Baris 49
        // Baris 50
        // Baris 51
        // Baris 52
        // Baris 53
        // Baris 54
        // Baris 55
        // Baris 56
        // Baris 57
        // Baris 58
        // Baris 59
        // Baris 60
        // Baris 61
        // Baris 62
        // Baris 63
        // Baris 64
        // Baris 65
        // Baris 66
        // Baris 67
        // Baris 68
        // Baris 69
        // Baris 70
        // Baris 71
        // Baris 72
        // Baris 73
        // Baris 74
        // Baris 75
        // Baris 76
        // Baris 77
        // Baris 78
        // Baris 79
        // Baris 80
        // Baris 81
        // Baris 82
        // Baris 83
        // Baris 84
        // Baris 85
        // Baris 86
        // Baris 87
        // Baris 88
        // Baris 89
        // Baris 90
        // Baris 91
        // Baris 92
        // Baris 93
        // Baris 94
        // Baris 95
        // Baris 96
        // Baris 97
        // Baris 98
        // Baris 99
        // Baris 100
        // Baris 101
        // Baris 102
        // Baris 103
        // Baris 104
        // Baris 105
        // Baris 106
        // Baris 107
        // Baris 108
        // Baris 109
        // Baris 110
        // Baris 111
        // Baris 112
        // Baris 113
        // Baris 114
        // Baris 115
        // Baris 116
        // Baris 117
        // Baris 118
        // Baris 119
        // Baris 120
        // Baris 121
        // Baris 122
        // Baris 123
        // Baris 124
        // Baris 125
        // Baris 126
        // Baris 127
        // Baris 128
        // Baris 129
        // Baris 130
        // Baris 131
        // Baris 132
        // Baris 133
        // Baris 134
        // Baris 135
        // Baris 136
        // Baris 137
        // Baris 138
        // Baris 139
        // Baris 140
        // Baris 141
        // Baris 142
        // Baris 143
        // Baris 144
        // Baris 145
        // Baris 146
        // Baris 147
        // Baris 148
        // Baris 149
        // Baris 150
        // Baris 151
        // Baris 152
        // Baris 153
        // Baris 154
        // Baris 155
        // Baris 156
        // Baris 157
        // Baris 158
        // Baris 159
        // Baris 160
        // Baris 161
        // Baris 162
        // Baris 163
        // Baris 164
        // Baris 165
        // Baris 166
        // Baris 167
        // Baris 168
        // Baris 169
        // Baris 170
        // Baris 171
        // Baris 172
        // Baris 173
        // Baris 174
        // Baris 175
        // Baris 176
        // Baris 177
        // Baris 178
        // Baris 179
        // Baris 180
        // Baris 181
        // Baris 182
        // Baris 183
        // Baris 184
        // Baris 185
        // Baris 186
        // Baris 187
        // Baris 188
        // Baris 189
        // Baris 190
        // Baris 191
        // Baris 192
        // Baris 193
        // Baris 194
        // Baris 195
        // Baris 196
        // Baris 197
        // Baris 198
        // Baris 199
        // Baris 200
        // Baris 201
        // Baris 202
        // Baris 203
        // Baris 204
        // Baris 205
        // Baris 206
        // Baris 207
        // Baris 208
        // Baris 209
        // Baris 210
        // Baris 211
        // Baris 212
        // Baris 213
        // Baris 214
        // Baris 215
        // Baris 216
        // Baris 217
        // Baris 218
        // Baris 219
        // Baris 220
        // Baris 221
        // Baris 222
        // Baris 223
        // Baris 224
        // Baris 225
        // Baris 226
        // Baris 227
        // Baris 228
        // Baris 229
        // Baris 230
        // Baris 231
        // Baris 232
        // Baris 233
        // Baris 234
        // Baris 235
        // Baris 236
        // Baris 237
        // Baris 238
        // Baris 239
        // Baris 240
        // Baris 241
        // Baris 242
        // Baris 243
        // Baris 244
        // Baris 245
        // Baris 246
        // Baris 247
        // Baris 248
        // Baris 249
        // Baris 250
        // Baris 251
        // Baris 252
        // Baris 253
        // Baris 254
        // Baris 255
        // Baris 256
        // Baris 257
        // Baris 258
        // Baris 259
        // Baris 260
        // Baris 261
        // Baris 262
        // Baris 263
        // Baris 264
        // Baris 265
        // Baris 266
        // Baris 267
        // Baris 268
        // Baris 269
        // Baris 270
        // Baris 271
        // Baris 272
        // Baris 273
        // Baris 274
        // Baris 275
        //






