import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { FilmSerie } from 'src/app/models/models';
import { FilmserieService } from '../filmserie.service';

@Component({
  selector: 'app-update-film',
  templateUrl: './update-film.component.html',
  styleUrls: ['./update-film.component.scss']
})
export class UpdateFilmComponent implements OnInit {

  film: FilmSerie;
  formUpdate: FormGroup;

  constructor(
    private router: Router,
    private formBuilder: FormBuilder,
    private activateRouted: ActivatedRoute,
    private filmService: FilmserieService
  ) {
    this.formUpdate = formBuilder.group({
      fs_nom: new FormControl(null),
      fs_synopsis: new FormControl(null),
      fs_img: new FormControl(null),
      fs_saison: new FormControl(0),
      fs_episode: new FormControl(0),
      fs_date_sortie: new FormControl(null),
      ge_genre: new FormControl(null),
      ty_type:new FormControl(null)
    })
  }

  ngOnInit(): void {
    this.activateRouted.params.subscribe(
      params => this.filmService.getById(params.id).subscribe(x => {
        this.film = x;
        this.initForm();
      })
    )
  }

  initForm() {
    this.formUpdate.get("fs_nom").setValue(this.film.fs_nom);
    this.formUpdate.get("fs_synopsis").setValue(this.film.fs_synopsis);
    this.formUpdate.get("fs_date_sortie").setValue(this.film.fs_date_sortie);
    if (this.film.ty_type.ty_id == 1) {
      this.formUpdate.get("fs_saison").setValue(this.film.fs_saison);
      this.formUpdate.get("fs_episode").setValue(this.film.fs_episode);
    }
    this.formUpdate.get("fs_img") != null ? this.formUpdate.get("fs_img").setValue(this.film.fs_img) : ''
    this.formUpdate.get("ty_type").setValue(this.film.ty_type);
    this.formUpdate.get("ge_genre").setValue(this.film.ge_genre);
  }

  onClickUpdate(id:number) {
    // let jsonFile = this.buildJsonFile(this.formUpdate);
    // this.filmService.patchFilm(jsonFile, this.film.fs_id);
    this.filmService.updateFilm(this.formUpdate.value, id);
  }

  buildJsonFile(form: FormGroup) {
    let jsonFile: object = {};
    this.film.fs_nom != form.get("fs_nom").value ? jsonFile['fs_nom'] = form.get("fs_nom").value : ''
    this.film.fs_synopsis != form.get("fs_synopsis").value ? jsonFile['fs_synopsis'] = form.get("fs_synopsis").value : ''
    this.film.fs_date_sortie != form.get("fs_date_sortie").value ? jsonFile['fs_date_sortie'] = form.get("fs_date_sortie").value : ''
    this.film.fs_img != form.get("fs_img").value ? jsonFile['fs_img'] = form.get("fs_img").value : ''
    if (this.film.ty_type.ty_id) {
      this.film.fs_saison != form.get("fs_saison").value ? jsonFile['fs_saison'] = form.get("fs_saison").value : ''
      this.film.fs_episode != form.get("fs_episode").value ? jsonFile['fs_episode'] = form.get("fs_episode").value : ''
    }
    return jsonFile;
  }
}
