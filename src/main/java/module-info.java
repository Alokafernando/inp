module org.example.practicleexam {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.practicleexam to javafx.fxml;
    exports org.example.practicleexam;
}