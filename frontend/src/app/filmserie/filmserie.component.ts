import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { FilmSerie } from '../models/models';
import { FilmserieService } from './filmserie.service';

@Component({
  selector: 'app-filmserie',
  templateUrl: './filmserie.component.html',
  styleUrls: ['./filmserie.component.scss']
})
export class FilmserieComponent implements OnInit {
  medias$: Observable<FilmSerie[]>;

  constructor(
    private filmSerieService: FilmserieService
  ) { }

  ngOnInit(): void {
    /*const myObserver = {
       next: x => console.log(x),
       error: err => console.error(err),
       complete: () => console.log('Observer got a complete notification'),
     };*/
    this.medias$ = this.filmSerieService.getAll();
    //this.medias$.subscribe(myObserver);
  }

  onClickDelete(id: number) {
    if (confirm("Voulez-vous vraiment supprimer ? ")) {
      this.filmSerieService.deleteById(id).subscribe(
        m => {console.log(m);
          this.medias$ = this.filmSerieService.getAll();
        }        
        );
    }  
  }
}
