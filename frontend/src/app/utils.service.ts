import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Genre, Personne, Type } from './models/models';

@Injectable({
  providedIn: 'root'
})
export class UtilsService {

  private BASE_URL = "http://localhost:8080/GestionCollectionFilmSerie";

  constructor(private httpClient: HttpClient) { }

  static choixpeauMagique(element: Personne, acteursInFilm: Personne[], producteurInFilm: Personne[], realisateurInFilm: Personne[]) {
    switch (element.per_role) {
      case 'Acteur':
        acteursInFilm.push(element);
        break;
      case 'Producteur':
        producteurInFilm.push(element);
        break;
      case 'Realisateur':
        realisateurInFilm.push(element);
        break;
      default:
        break;
    }
  }

  //chercher les genre dans la db
  recupGenre(): Observable<Genre[]> {
    return this.httpClient.get<Genre[]>(this.BASE_URL + '/apiGenre');
  }
  //chercher les types dans la db
  recupType(): Observable<Type[]>{
    return this.httpClient.get<Type[]>(this.BASE_URL + '/apiType');
  }
}
