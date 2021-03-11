import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { PersonneService } from '../personne.service';

@Component({
  selector: 'app-add-personne',
  templateUrl: './add-personne.component.html',
  styleUrls: ['./add-personne.component.scss']
})
export class AddPersonneComponent implements OnInit {
  formAddPers: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private personneService: PersonneService) {
    this.formAddPers = this.formBuilder.group({
      per_nom: new FormControl(null, [Validators.required]),
      per_prenom: new FormControl(null, [Validators.required]),
      per_ddn: new FormControl(null, [Validators.required]),
      per_genre: new FormControl(1, [Validators.required]),
      per_url!: new FormControl(null)
    });
  }

  ngOnInit(): void {
  }

  onClick() {
    this.personneService.insert(this.formAddPers.value);
  }

}
