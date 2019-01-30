import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
@Component({
  selector: 'app-ridedetails',
  templateUrl: './ridedetails.component.html',
  styleUrls: ['./ridedetails.component.css']
})
export class RidedetailsComponent implements OnInit {
  rideId: number;
  constructor(private activatedroute: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.activatedroute.paramMap.subscribe((params: ParamMap) => {
      this.rideId = parseInt(params.get('id'));
    });   

  }

}
