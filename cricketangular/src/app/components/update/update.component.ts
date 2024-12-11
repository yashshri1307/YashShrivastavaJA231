import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Player } from 'src/app/models/Player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent {

  updateForm!: FormGroup;
  playerId!: number;
  player!: Player;
  errorMessage!: string;
  submitted = false;

  constructor(
    private formBuilder: FormBuilder,
    private service: PlayerService,
    private router: Router
  ) {}

  ngOnInit(): void {

    this.updateForm = this.formBuilder.group({
      playerId: ['', Validators.required],
      playerName: ['', Validators.required],
      jerseyNumber: ['', [Validators.required, Validators.min(1)]],
      role: ['',[Validators.required, Validators.pattern(/^(WicketKeeper|Bowler|Batsman|Allrounder)$/)]],
      totalMatches: ['', [Validators.required, Validators.min(0)]],
      teamName: ['', Validators.required],
      countryName: ['', Validators.required],
      description: ['', Validators.required]
    });
  }

  get f() {
    return this.updateForm.controls;
  }

  updatePlayer() {
    this.submitted = true;

    if (this.updateForm.invalid) {
      return;
    }

    const playerId = this.updateForm.value.playerId;

    const updatedPlayer: Player = {
      playerId: playerId,
      playerName: this.updateForm.value.playerName,
      jerseyNumber: this.updateForm.value.jerseyNumber,
      role: this.updateForm.value.role,
      totalMatches: this.updateForm.value.totalMatches,
      teamName: this.updateForm.value.teamName,
      countryName: this.updateForm.value.countryName,
      description: this.updateForm.value.description
    };

    this.service.updatePlayer(updatedPlayer).subscribe(
      (response) => {
        console.log('Player updated successfully:', response);
        alert('Player updated successfully!');
        this.router.navigate(['/home']);
      },
      (error) => {
        console.error('Error updating player:', error);
        this.errorMessage = 'Failed to update player data';
      }
    );
  }
}
