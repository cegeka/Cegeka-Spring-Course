import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {RouterModule, Routes} from '@angular/router';
import {HeaderComponent} from './header/header.component';
import {BooksComponent} from './books/books.component';
import {RatingsComponent} from './ratings/ratings.component';
import {HttpClientModule} from '@angular/common/http';
import {BooksAddComponent} from './books-add/books-add.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

const appRoutes: Routes = [
  {path: 'books', component: BooksComponent},
  {path: 'books-add', component: BooksAddComponent},
  {path: 'ratings', component: RatingsComponent},
  {path: '**', redirectTo: 'books', pathMatch: 'full'},
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BooksComponent,
    RatingsComponent,
    BooksAddComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(appRoutes),
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
