import {Component, Input, OnChanges, SimpleChanges} from "@angular/core";
import {AbstractControl, ValidationErrors} from "@angular/forms";
import {CommonModule} from "@angular/common";

@Component({
  selector: 'validation-message',
  templateUrl: 'validation.message.html',
  styleUrls: ['validation.message.css'],
  standalone: true,
  imports: [CommonModule]
})
export class ValidationMessage implements OnChanges {

  @Input() control: AbstractControl;
  message: string;

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges): void {
    this.control.statusChanges.subscribe(s => {
      const errors = this.control.errors;
      if (errors != null) {
        Object.keys(errors).forEach(key => {
          this.message = this.getMessage(errors, key);
        })
      }
    })
  }

  getMessage(errors: ValidationErrors, key: string) {
    switch (key) {
      case 'required':
        return 'Required';
      case 'minlength':
        return 'Minimum length ' + errors['minlength'].requiredLength;
      case 'maxlength':
        return 'Maximum length ' + errors['maxlength'].requiredLength;
      case 'pattern':
        return 'Invalid character';
      default:
        return 'Invalid';
    }
  }

}
