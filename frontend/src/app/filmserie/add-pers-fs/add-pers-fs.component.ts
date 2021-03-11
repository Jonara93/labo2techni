import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FilmSerie, Personne } from 'src/app/models/models';
import { PersonneService } from 'src/app/personne/personne.service';
import { UtilsService } from 'src/app/utils.service';
import { FilmserieService } from '../filmserie.service';

@Component({
  selector: 'app-add-pers-fs',
  templateUrl: './add-pers-fs.component.html',
  styleUrls: ['./add-pers-fs.component.scss']
})
export class AddPersFSComponent implements OnInit {

  formAddPerToFS: FormGroup;
  film: FilmSerie;
  allPers: Personne[];
  allPersInTheFilm: Personne[];
  acteursInTheFilm: Personne[] = [];
  realisateursInTheFilm: Personne[] = [];
  producteursInTheFilm: Personne[] = [];
  acteurToAdd: number[] = [];

  constructor(
    private formBuilder: FormBuilder,
    private personneService: PersonneService,
    private filmSerieService: FilmserieService,
    private activateRoute: ActivatedRoute,
    private router: Router
  ) {
    this.formAddPerToFS = this.formBuilder.group({
      acteursToAdd: new FormControl(null),
      realisateurToAdd: new FormControl(null),
      producteursToAdd: new FormControl(null)
    })
  }

  ngOnInit(): void {
    this.personneService.getAll().subscribe(x => {
      this.allPers = x;
      this.activateRoute.params.subscribe(params => {
        this.filmSerieService.getPersonneFromFilm(params.id).subscribe(
          x => {
            this.allPersInTheFilm = x;
            this.allPersInTheFilm.forEach(
              element => {
                UtilsService.choixpeauMagique(element, this.acteursInTheFilm,
                  this.producteursInTheFilm, this.realisateursInTheFilm)
              }
            )
          }
        );
        this.filmSerieService.getById(params.id).subscribe(x => this.film = x);
      })
    });
    // this.allPersInTheFilm$ = this.filmSerieService;
  }

  //ajouter personnes dans un film avec son role
  addPersToFS(id:number) {
    if (this.formAddPerToFS.get("acteursToAdd").value != null) {
      this.formAddPerToFS.get("acteursToAdd").value.forEach(element => {
        this.filmSerieService.insertPersInFilm(this.film.fs_id, element, 1);
      });
    };
    if (this.formAddPerToFS.get("realisateurToAdd").value != null) {
      this.formAddPerToFS.get("realisateurToAdd").value.forEach(element => {
        this.filmSerieService.insertPersInFilm(this.film.fs_id, element, 2);
      });
    };
    if (this.formAddPerToFS.get("producteursToAdd").value != null) {
      this.formAddPerToFS.get("producteursToAdd").value.forEach(element => {
        this.filmSerieService.insertPersInFilm(this.film.fs_id, element, 3);
      });
    };
    this.router.navigate(['detail/'+id]).then();

  }

  isOnActeursList(p: number) {
    let isOnList = false;
    this.acteursInTheFilm?.forEach(element => {
      if (element.per_id == p) {
        isOnList = true;
      };
    });
    return isOnList;
  }

  isOnRealisateurList(p: number) {
    let isOnList = false;
    this.realisateursInTheFilm?.forEach(element => {
      if (element.per_id == p) {
        isOnList = true;
      };
    });
    return isOnList;
  }

  isOnProducteurList(p: number) {
    let isOnList = false;
    this.producteursInTheFilm?.forEach(element => {
      if (element.per_id == p) {
        isOnList = true;
      };
    });
    return isOnList;
  }

}
