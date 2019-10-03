import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup} from '@angular/forms';
import {BookService} from '../book.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-books-add',
  templateUrl: './books-add.component.html',
  styleUrls: ['./books-add.component.css']
})
export class BooksAddComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder, private bookService: BookService, private router: Router) { }

  ngOnInit() {
    this.form = this.formBuilder.group({
      name: '',
      author: ''
    });
  }

  submit() {
    this.bookService.addBook(this.form.value)
      .subscribe(book => this.router.navigateByUrl(''));
    console.log(this.form.value);
  }
}
