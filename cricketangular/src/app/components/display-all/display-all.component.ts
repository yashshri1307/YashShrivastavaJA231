import { Component } from '@angular/core';
import { Player } from 'src/app/models/Player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-display-all',
  templateUrl: './display-all.component.html',
  styleUrls: ['./display-all.component.css']
})
export class DisplayAllComponent {

  players: Player[] = [];
  errorMessage!: string;

  constructor(private service:PlayerService) {}

  ngOnInit(): void {
    this.display();
  }

  display() {
    this.service.getAllPlayers().subscribe(
      (data:any) => {
        this.players = data;
      },
      (error:string) => {
        console.error('Error Display players:', error);
        this.errorMessage = 'Failed to get player details';
      }
    );
  }
}


