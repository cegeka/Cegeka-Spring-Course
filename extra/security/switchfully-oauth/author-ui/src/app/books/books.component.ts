import {Component, OnInit} from '@angular/core';
import {Observable} from 'rxjs';
import {BookService} from '../book.service';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {

  books$: Observable<any[]>;
  rated = [];

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.books$ = this.bookService.getAllBooks();
  }

  rate(bookId, amount) {
    this.rated.push(bookId);
    this.bookService.rate(bookId, {scoreOutOfFive: amount, raterName: 'Ratey McRateFace'})
      .subscribe(() => console.log('Rating successful'));
  }

}
