package com.example.demo.Service;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import com.example.demo.Model.Book;
import jakarta.annotation.PostConstruct;
@Service
public class BookService {
    // Khởi tạo danh sách các cuốn sách
    private List<Book> books = new ArrayList<>();
    private int nextId = 4;

    // Lấy toàn bộ danh sách sách
    public List<Book> getAllBooks() {
        return books;
    }

    @PostConstruct
    public void initData() {
        books.add(new Book(1, "Lập trình Java cơ bản", "Nguyễn Văn A"));
        books.add(new Book(2, "Spring Boot cho người mới bắt đầu", "Trần Thị B"));
        books.add(new Book(3, "Cấu trúc dữ liệu và Giải thuật", "Phạm Văn C"));
    }

    // Tìm kiếm sách theo ID bằng Stream API
    public Book getBookById(int id) {
        return books.stream()
                .filter(book -> book.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Thêm một cuốn sách mới vào danh sách
    public void addBook(Book book) {
        book.setId(nextId++); // Tự động gán ID mới
        books.add(book);
    }
        // 4. Cập nhật thông tin sách
        public void updateBook(int id, Book updatedBook) {
            books.stream()
                    .filter(book -> book.getId() == id)
                    .findFirst()
                    .ifPresent(book -> {
                        book.setTitle(updatedBook.getTitle());
                        book.setAuthor(updatedBook.getAuthor());
                    });
        }

        // 5. Xóa sách theo ID
        public void deleteBook(int id) {
            books.removeIf(book -> book.getId() == id);
        }

}

