const ValidatePhoneNumber = (phoneNumber: string) => {
  for (let i = 0; i < phoneNumber.length; i += 1) {
    if (phoneNumber[i].charCodeAt((0)) >= 48 && phoneNumber[i].charCodeAt((0)) <= 57) { return false; }
    else {
      return false;
    }
  }
}
export { ValidatePhoneNumber }
