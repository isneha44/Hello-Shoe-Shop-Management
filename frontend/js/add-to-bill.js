document.getElementById('loyaltySelect').addEventListener('change', function() {
    var loyaltyIdContainer = document.getElementById('loyaltyIdContainer');
    var loyaltyIdInput = document.getElementById('loyaltyIdInput');
    if (this.value === 'yes') {
        loyaltyIdContainer.classList.remove('loyality-id-hidden');
        loyaltyIdInput.setAttribute('required', 'required');
    } else {
        loyaltyIdContainer.classList.add('loyality-id-hidden');
        loyaltyIdInput.removeAttribute('required');
    }
});