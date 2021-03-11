import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Personne } from '../models/models';

@Injectable({
  providedIn: 'root'
})
export class PersonneService {


  private BASE_URL = 'http://localhost:8080/GestionCollectionFilmSerie/apiPers';

  constructor(
    private httpClient: HttpClient,
    private router: Router
  ) { }

  getAll(): Observable<Personne[]> {
    return this.httpClient.get<Personne[]>(this.BASE_URL);
  }

  getById(id: number): Observable<Personne> {
    return this.httpClient.get<Personne>(this.BASE_URL + "/" + id);
  }

  deleteById(id): Observable<string> {
    return this.httpClient.delete<string>(
      this.BASE_URL + "/" + id
    );
  }

  insert(value: Personne) {
    this.httpClient.post(
      this.BASE_URL,
      value
    ).subscribe(
      () => this.router.navigate(
        ['personne']).then()
    );
  }

  updateById(value: Personne) {
    this.httpClient.put(
      this.BASE_URL + "/" + value.per_id,
      value
    ).subscribe(
      () => this.router.navigate(
        ['personne']).then()
    );
  }
}