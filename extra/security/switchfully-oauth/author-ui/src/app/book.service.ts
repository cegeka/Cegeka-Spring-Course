import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) { }

  getAllBooks(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:8080/book');
  }

  addBook(book: any) {
    return this.http.post('http://localhost:8080/book', book);
  }

  rate(bookId: any, rating: any) {
    return this.http.put('http://localhost:8080/book/rate/' + bookId, rating);
  }

  getAllBooksWithRatings() {
    return this.http.get<any[]>('http://localhost:8080/book/rated');
  }
}
