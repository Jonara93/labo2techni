import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup } from '@angular/forms';
import { Genre, Type } from 'src/app/models/models';
import { UtilsService } from 'src/app/utils.service';
import { FilmserieService } from '../filmserie.service';

@Component({
  selector: 'app-add-film',
  templateUrl: './add-film.component.html',
  styleUrls: ['./add-film.component.scss']
})
export class AddFilmComponent implements OnInit {

  formAddFilm: FormGroup;
  allGenres: Genre[];
  allTypes: Type[];
  optionSelected;


  constructor(
    private formBuilder: FormBuilder,
    private filmSerieService: FilmserieService,
    private utils: UtilsService
  ) {
    this.formAddFilm = formBuilder.group({
      fs_nom: new FormControl(null),
      fs_synopsis: new FormControl(null),
      fs_date_sortie: new FormControl(null),
      ge_genre: new FormControl(0),
      ty_type: new FormControl(0),
      fs_saison: new FormControl(0),
      fs_episode: new FormControl(0),
      fs_img: new FormControl(null)
    })
  }

  ngOnInit(): void {
    this.utils.recupGenre().subscribe(x => this.allGenres = x);
    this.utils.recupType().subscribe(x => this.allTypes = x);
  }

  onClickAdd() {
    let jsonFile = this.constructJson(this.formAddFilm);
    this.filmSerieService.insertFilm(jsonFile);
    
  }

  constructJson(formAddFilm: FormGroup) {
    let jsonFile : object = {
      "fs_nom": formAddFilm.get("fs_nom").value,
      "fs_synopsis": formAddFilm.get("fs_synopsis").value,
      "fs_img": formAddFilm.get("fs_img").value,
      "ty_type": {
        "ty_id": formAddFilm.get("ty_type").value
      },
      "fs_date_sortie": formAddFilm.get("fs_date_sortie").value+"T00:00:00",
      "ge_genre": {
        "ge_id": formAddFilm.get("ge_genre").value
      }
    }
    if (formAddFilm.get("ty_type").value == 1) {
      jsonFile['fs_saison'] = formAddFilm.get("fs_saison").value;
      jsonFile['fs_episode'] = formAddFilm.get("fs_episode").value;  
    }
    return jsonFile;
  }

}
