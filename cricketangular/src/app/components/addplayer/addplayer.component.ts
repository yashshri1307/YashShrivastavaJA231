import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Player } from 'src/app/models/Player';
import { PlayerService } from 'src/app/services/player.service';

@Component({
  selector: 'app-addplayer',
  templateUrl: './addplayer.component.html',
  styleUrls: ['./addplayer.component.css']
})
export class AddplayerComponent {

  constructor(private service:PlayerService,private formBuilder:FormBuilder,private router:Router){}

  addform!:FormGroup;
  submitted=false;

  player:Player[]=[];
  errorMessage!:string;

  ngOnInit(){
    this.addform=this.formBuilder.group({

    playerName: ['',Validators.required],
    jerseyNumber: ['',[Validators.required, Validators.min(1)]],
    role: ['',[Validators.required, Validators.pattern(/^(WicketKeeper|Bowler|Batsman|Allrounder)$/)]],
    totalMatches: ['',[Validators.required, Validators.min(0)]],
    teamName: ['',Validators.required],       
    countryName: ['',Validators.required],    
    description: ['',Validators.required]
       
    });
  }
  get f() {
    return this.addform.controls;
  }

  add() {
    if (this.addform.valid) {
      this.service.addPlayer(this.addform.value).subscribe(
        (response) => {
          console.log('Player added successfully:', response);
          alert('Player added successfully!');
          this.addform.reset();
          this.router.navigate(['/home']);
        },
        (error) => {
          console.error('Error adding player:', error);
          this.errorMessage = 'error adding the player.';
        }
      );
    } else {
      alert('Form is invalid! Please fill all fields correctly.');
    }
  }
  
}



