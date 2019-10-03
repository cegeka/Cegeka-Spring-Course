import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BookService {

  constructor(private http: HttpClient) {
  }

  getAllBooks(): Observable<any[]> {
    return this.http.get<any[]>('http://localhost:4445/book');
  }

  addBook(book: any) {
    return this.http.post('http://localhost:4445/book', book, this.createBearerHeader());
  }

  rate(bookId: any, rating: any) {
    return this.http.put('http://localhost:4445/book/rate/' + bookId, rating, this.createBearerHeader());
  }

  getAllBooksWithRatings() {
    return this.http.get<any[]>('http://localhost:4445/book/rated', this.createBearerHeader());
  }

  private createBearerHeader() {
    const token = localStorage.getItem('access_token');
    return {headers: new HttpHeaders().set('Authorization', 'Bearer ' + token)};
  }
}
