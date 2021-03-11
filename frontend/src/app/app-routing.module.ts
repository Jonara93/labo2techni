import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddFilmComponent } from './filmserie/add-film/add-film.component';
import { AddPersFSComponent } from './filmserie/add-pers-fs/add-pers-fs.component';
import { DetailComponent } from './filmserie/detail/detail.component';
import { FilmserieComponent } from './filmserie/filmserie.component';
import { UpdateFilmComponent } from './filmserie/update-film/update-film.component';
import { AddPersonneComponent } from './personne/add-personne/add-personne.component';
import { PersonneComponent } from './personne/personne.component';
import { UpdatePersonneComponent } from './personne/update-personne/update-personne.component';

const routes: Routes = [
  {
    path: '', component: FilmserieComponent, children: [
      {
        path: 'detail/:id', component: DetailComponent
      }]
  },
  {
    path: 'update/:id', component: UpdateFilmComponent
  },
  {
    path: 'addFilm', component: AddFilmComponent
  },
  {
    path: 'personne', component: PersonneComponent
  },
  {
    path: 'personne/addPersonne', component: AddPersonneComponent
  },
  {
    path: 'personne/updatePersonne/:id', component: UpdatePersonneComponent
  },
  {
    path: 'detail/:id/addPers', component: AddPersFSComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
