export interface Type {
    ty_id: number;
    ty_type: string;
}

export interface Genre {
    ge_id: number;
    ge_nom: string;
}

export interface FilmSerie {
    fs_id: number;
    fs_nom: string;
    fs_synopsis: string;
    ty_type: Type;
    /*fs_date_sortie: {
        date: {
            day: number;
            month: number;
            year: number;
        };
        time: {
            hour: number;
            minute: number;
            second: number;
            nano: number;
        }
    };*/
    fs_date_sortie: Date;
    ge_genre: Genre;
    fs_saison: number;
    fs_episode: number;
    fs_img: string;
}

export interface Personne {
    per_id: number;
    per_nom: string;
    per_prenom: string;
    per_genre: string;
    per_ddn: Date;
    per_url:string;
    per_role:string;
}