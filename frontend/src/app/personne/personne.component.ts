import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Personne } from '../models/models';
import { PersonneService } from './personne.service';

@Component({
  selector: 'app-personne',
  templateUrl: './personne.component.html',
  styleUrls: ['./personne.component.scss']
})
export class PersonneComponent implements OnInit {
  pers$: Observable<Personne[]>;
  per: Personne;
  toggleDetailPer = false;
  iDtoggleDetailPer: Number;

  constructor(
    private personneService: PersonneService
  ) { }

  ngOnInit(): void {
    this.pers$ = this.personneService.getAll();
    this.per;
  }

  onClickDetail(id: number) {
    if (this.toggleDetailPer === false || this.iDtoggleDetailPer != id) {
      this.personneService.getById(id).subscribe(f => this.per = f);
      this.toggleDetailPer = true;
      this.iDtoggleDetailPer = id;
    }
    else {
      this.toggleDetailPer = false;
    }
  }

  onClickDelete(id: number) {
    if (confirm("Voulez-vous vraiment supprimer ? ")) {
      this.personneService.deleteById(id).subscribe(
        m => {
          console.log(m);
          this.pers$ = this.personneService.getAll();
        }
      );
    }
  }
}
