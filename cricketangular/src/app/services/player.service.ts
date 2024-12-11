import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Player } from '../models/Player';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PlayerService {

  baseURL:string="http://localhost:8080/api/players"

  constructor(private http:HttpClient) { }

  addPlayer(player:Player):Observable<Player>{

    return this.http.post<Player>(this.baseURL+"/add",player);
  }

  getAllPlayers(): Observable<Player[]> {
    return this.http.get<Player[]>(this.baseURL+"/getall");
  }
  
  updatePlayer(player: Player): Observable<Player> {
    return this.http.put<Player>(`${this.baseURL}/update/${player.playerId}`, player);
  }

}
