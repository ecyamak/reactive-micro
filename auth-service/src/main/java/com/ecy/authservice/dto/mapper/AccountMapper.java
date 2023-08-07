package com.ecy.authservice.dto.mapper;

import com.ecy.authservice.dto.AccountDTO;
import com.ecy.authservice.entity.Account;
import org.mapstruct.Mapper;

/**
 * Author: ecyamak
 * Date: 7.08.2023
 * Time: 22:25
 */

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account mapToAccount(AccountDTO accountDTO);

    AccountDTO mapToAccountDTO(Account account);

}