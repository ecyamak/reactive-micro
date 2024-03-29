import {Component} from "@angular/core";
import {SearchbarComponent} from "./searchbar.component";
import {Router} from "@angular/router";
import {AuthService} from "../service/auth.service";

@Component({
  standalone: true,
  selector: 'navbar',
  imports: [SearchbarComponent],
  template:
    '<div class="w3-top">' +
    '  <div class="w3-bar ecy-theme-darker-blue w3-left-align w3-large">' +
    '    <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large ecy-hover-white"><i class="fa fa-bars"></i></a>' +
    '    <a href="/login" class="w3-bar-item w3-button w3-padding-large ecy-hover-white"><i class="fa fa-leaf w3-margin-right"></i>springbook</a>' +
    '    <a class="w3-bar-item w3-button w3-hide-small w3-padding-large ecy-hover-white" title="News"><i class="fa fa-house"></i></a>' +
    '    <a class="w3-bar-item w3-button w3-hide-small w3-padding-large ecy-hover-white" title="Profile"><i class="fa fa-user"></i></a>' +
    '    <a class="w3-bar-item w3-button w3-hide-small w3-padding-large ecy-hover-white" title="Messages"><i class="fa fa-message"></i></a>' +
    '    <div class="w3-dropdown-hover w3-hide-small">' +
    '      <button class="w3-button w3-padding-large ecy-hover-white" title="Notifications"><i class="fa fa-bell"></i><span class="w3-badge w3-right w3-small w3-green">3</span></button>' +
    '      <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px">' +
    '        <a class="w3-bar-item w3-button">One new friend request</a>' +
    '        <a class="w3-bar-item w3-button">John Doe posted on your wall</a>' +
    '        <a class="w3-bar-item w3-button">Jane likes your post</a>' +
    '      </div>' +
    '    </div>' +
    '    <button (click)="logout()" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large ecy-hover-white" title="Logout"><i class="fa fa-right-from-bracket"></i></button>' +
    '    <a class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large ecy-hover-white" title="Settings"><i class="fa fa-gear"></i></a>' +
    '    <!--' +
    '    <a class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">' +
    '      <img src="../assets/images/avatar.png" class="w3-circle" style="height:23px;width:23px" alt="Avatar">' +
    '    </a>' +
    '    -->' +
    '    <searchbar/>' +
    '  </div>' +
    '</div>' +
    '<!-- Navbar on small screens -->' +
    '<div id="navDemo" class="w3-bar-block w3-theme-d2 w3-hide w3-hide-large w3-hide-medium w3-large">' +
    '  <a class="w3-bar-item w3-button w3-padding-large">Link 1</a>' +
    '  <a class="w3-bar-item w3-button w3-padding-large">Link 2</a>' +
    '  <a class="w3-bar-item w3-button w3-padding-large">Link 3</a>' +
    '  <a class="w3-bar-item w3-button w3-padding-large">My Profile</a>' +
    '</div>'
})
export class NavbarComponent {

  constructor(private router: Router,
              private authService: AuthService) {
  }

  logout() {
    //sessionStorage.removeItem('token');
    this.router.navigateByUrl('/login');
  }

}
