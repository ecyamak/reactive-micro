import {Component, Input} from "@angular/core";
import {AbstractControl} from "@angular/forms";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'validation-message',
  templateUrl: 'validation.message.html',
  styleUrls: ['validation.message.css'],
  standalone: true,
  imports: [CommonModule]
})
export class ValidationMessage {

  @Input() control!: AbstractControl;

  constructor() {
  }

}
