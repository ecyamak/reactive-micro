import {Component} from "@angular/core";

@Component({
  standalone: true,
  selector: 'searchbar',
  template:
    '<div class="w3-dropdown-hover w3-hide-small w3-right ecy-theme-darker-blue">' +
    '  <form>' +
    '    <input type="text" placeholder="Search..." name="search">' +
    '    <button type="submit" class="w3-button w3-padding-large ecy-hover-white"><i class="fa fa-magnifying-glass"></i></button>' +
    '  </form>' +
    '</div>',
  styleUrls: ['./searchbar.component.css']
})
export class SearchbarComponent {

}
