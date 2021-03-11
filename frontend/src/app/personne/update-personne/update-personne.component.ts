import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Personne } from 'src/app/models/models';
import { PersonneService } from '../personne.service';

@Component({
  selector: 'app-update-personne',
  templateUrl: './update-personne.component.html',
  styleUrls: ['./update-personne.component.scss']
})
export class UpdatePersonneComponent implements OnInit {
  formUpdatePer: FormGroup;
  per: Personne;
  prenom: string;
  nom: string;
  url: string;
  genre: string;
  ddn: Date;

  constructor(
    private formBuilder: FormBuilder,
    private activatedRoute: ActivatedRoute,
    private personneService: PersonneService
  ) {
    this.formUpdatePer = this.formBuilder.group({
      per_id: new FormControl(null),
      per_nom: new FormControl(null, [Validators.required]),
      per_prenom: new FormControl(null, [Validators.required]),
      per_ddn: new FormControl(null, [Validators.required]),
      per_genre: new FormControl(null, [Validators.required]),
      per_url!: new FormControl(null)
    });
  }

  ngOnInit(): void {
    this.activatedRoute.params.subscribe(params => {
      this.personneService.getById(params.id).subscribe(
        x =>  {
          this.initPer(x);
          this.putValue(x);
        }
      );
    });
  }

  initPer(x: Personne) {
    this.per = x;
    this.nom = this.per.per_nom;
    this.prenom = this.per.per_prenom;
    this.genre = this.per.per_genre;
    this.ddn = this.per.per_ddn;
    this.url = this.per.per_url;
  }

  onClickUpdate() {
    this.personneService.updateById(this.formUpdatePer.value);
  }

  putValue(x:Personne){
    this.formUpdatePer.get('per_id').setValue(x.per_id);
    this.formUpdatePer.get('per_nom').setValue(x.per_nom);
    this.formUpdatePer.get('per_prenom').setValue(x.per_prenom);
    this.formUpdatePer.get('per_ddn').setValue(x.per_ddn);
    this.formUpdatePer.get('per_genre').setValue(x.per_genre);
    this.formUpdatePer.get('per_url').setValue(x.per_url);
  }
}