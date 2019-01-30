import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, ParamMap } from '@angular/router';
@Component({
  selector: 'app-rideslist',
  templateUrl: './rideslist.component.html',
  styleUrls: ['./rideslist.component.css']
})
export class RideslistComponent implements OnInit {
  rides: number[] = [1, 2, 4, 4];
  constructor(private activatedroute: ActivatedRoute, private route: Router) { }
  ngOnInit() {
  }
  onBooking(rideId) {
    this.route.navigate(['/ride', rideId]);
  }
}
