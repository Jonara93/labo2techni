import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FilmSerie, Personne } from '../models/models';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class FilmserieService {



  private BASE_URL = 'http://localhost:8080/GestionCollectionFilmSerie/apiFilms';

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }

  getAll(): Observable<FilmSerie[]> {
    return this.httpClient.get<FilmSerie[]>(this.BASE_URL);
  }

  getById(id: number): Observable<FilmSerie> {
    return this.httpClient.get<FilmSerie>(this.BASE_URL + "/" + id);
  }

  getPersonneFromFilm(id: number): Observable<Personne[]> {
    return this.httpClient.get<Personne[]>(this.BASE_URL + '/pers/' + id);
  }

  deleteById(id: number): Observable<string> {
    return this.httpClient.delete<string>(
      this.BASE_URL + "/" + id
    );
  }

  insertPersInFilm(idFilm: number, idPersonne: number, idRole: number) {
    this.httpClient.post(
      this.BASE_URL + '/pers/' + idFilm,
      {
        "fs_id": idFilm,
        "per_id": idPersonne,
        "ro_id": idRole
      }
    ).subscribe();
  }

  removePersInFilm(ro_id: number, fs_id: number, per_id: number) {
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' }), body: {
        "fs_id": fs_id,
        "per_id": per_id,
        "ro_id": ro_id
      }
    };
    this.httpClient.delete(
      this.BASE_URL + '/pers/' + fs_id,
      httpOptions
    ).subscribe();
  }

  insertFilm(jsonFile) {
    this.httpClient.post(
      this.BASE_URL,
      jsonFile
    ).subscribe(() => this.router.navigate(
      ['']).then()
    );
  }

  updateFilm(jsonFile: object, id: number) {
    this.httpClient.put(
      this.BASE_URL + '/' + id,
      jsonFile
    ).subscribe(() => this.router.navigate(
      ['']).then()
    );
  }

  patchFilm(jsonFile: object, id: number) {
    this.httpClient.patch(
      this.BASE_URL + '/' + id,
      jsonFile
    ).subscribe(() => this.router.navigate(
      ['']).then()
    );
  }
}
