import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { FilmSerie, Personne } from 'src/app/models/models';
import { UtilsService } from 'src/app/utils.service';
import { FilmserieService } from '../filmserie.service';

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.scss']
})
export class DetailComponent implements OnInit {

  fs: FilmSerie;
  acteursInFilm: Personne[];
  producteurInFilm: Personne[];
  realisateurInFilm: Personne[];


  constructor(
    private activatedRoute: ActivatedRoute,
    private filmService: FilmserieService
  ) { }

  ngOnInit(): void {
    this.uneFonctionDouceQueMeChantaitMaMaman()
  }

  //retirer une personne du film pour un role
  removeFromFilm(ro_id: number, fs_id: number, per_id: number) {
    if (confirm('Etes-vous sûr ? ')) {
      if (confirm('Réellement sûr ?')) {
        this.filmService.removePersInFilm(ro_id, fs_id, per_id);
        this.uneFonctionDouceQueMeChantaitMaMaman();
      }
    };
  }
  
  uneFonctionDouceQueMeChantaitMaMaman(){
    this.activatedRoute.params.subscribe(params => {
      console.log(params);
      this.filmService.getById(params.id).subscribe(fs => {
        this.fs = fs;
        this.acteursInFilm = [];
        this.producteurInFilm = [];
        this.realisateurInFilm = [];
        this.filmService.getPersonneFromFilm(params.id).subscribe(persInFS => {
          persInFS.forEach(element => {
            UtilsService.choixpeauMagique(element, this.acteursInFilm, this.producteurInFilm, this.realisateurInFilm)
          });
        });
      });
    });
  }

}

