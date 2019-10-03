import {Component, OnInit} from '@angular/core';
import {BookService} from '../book.service';
import {Observable} from 'rxjs';

@Component({
  selector: 'app-ratings',
  templateUrl: './ratings.component.html',
  styleUrls: ['./ratings.component.css']
})
export class RatingsComponent implements OnInit {
  private books$: Observable<any[]>;

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.books$ = this.bookService.getAllBooksWithRatings();
  }

  getRatingsAvg(ratings: any[]) {
    return ratings.map(rating => rating.scoreOutOfFive)
      .reduce((r1, r2) => r1 + r2, 0) / ratings.length;
  }

  getRaters(ratings) {
    return 'Rated by:' + Array.from(new Set(ratings.map(rating => rating.raterName))).join(',');
  }
}
