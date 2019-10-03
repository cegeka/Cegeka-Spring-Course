import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {BookService} from '../book.service';
import {AuthService} from '../auth.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books$: Observable<any[]>;
  rated = [];

  constructor(private bookService: BookService, private authService: AuthService) {
  }

  ngOnInit() {
    this.books$ = this.bookService.getAllBooks();
  }

  rate(bookId, amount) {
    this.rated.push(bookId);
    this.bookService.rate(bookId, {
      scoreOutOfFive: amount,
      raterName: this.authService.getIdToken().given_name + ' ' + this.authService.getIdToken().family_name
    })
      .subscribe(() => console.log('Rating successful'));
  }

  canAddBooks() {
    return this.authService.hasPermission('create:book');
  }
}
