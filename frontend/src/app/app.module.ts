import { BrowserModule } from '@angular/platform-browser';
import { LOCALE_ID, NgModule } from '@angular/core';
import { CommonModule, registerLocaleData } from '@angular/common';
import localeFr from '@angular/common/locales/fr';
registerLocaleData(localeFr, 'fr');

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FilmserieComponent } from './filmserie/filmserie.component';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { DetailComponent } from './filmserie/detail/detail.component';
import { PersonneComponent } from './personne/personne.component';
import { AddPersonneComponent } from './personne/add-personne/add-personne.component';
import { UpdatePersonneComponent } from './personne/update-personne/update-personne.component';
import { AddPersFSComponent } from './filmserie/add-pers-fs/add-pers-fs.component';
import { AddFilmComponent } from './filmserie/add-film/add-film.component';
import { UpdateFilmComponent } from './filmserie/update-film/update-film.component';

@NgModule({
  declarations: [
    AppComponent,
    FilmserieComponent,
    DetailComponent,
    PersonneComponent,
    AddPersonneComponent,
    UpdatePersonneComponent,
    AddPersFSComponent,
    AddFilmComponent,
    UpdateFilmComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,
    ReactiveFormsModule
  ],
  providers: [{
    provide: LOCALE_ID, useValue: 'fr'
  }],
  bootstrap: [AppComponent]
})
export class AppModule { 

}
