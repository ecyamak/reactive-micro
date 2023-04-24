import {Component, Input} from "@angular/core";
import {FormGroup, ReactiveFormsModule} from "@angular/forms";
import {ValidationMessage} from "../../../utils/validation/validation.message";
import {InputTextModule} from "primeng/inputtext";
import {KeyFilterModule} from "primeng/keyfilter";

@Component({
  standalone: true,
  selector: 'input-text',
  templateUrl: 'input.text.component.html',
  imports: [InputTextModule, KeyFilterModule, ReactiveFormsModule, ValidationMessage]
})
export class InputTextComponent {

  @Input() id: string;
  @Input() formGroup: FormGroup;
  @Input() formControlName: string;
  @Input() keyFilter: string;

}
