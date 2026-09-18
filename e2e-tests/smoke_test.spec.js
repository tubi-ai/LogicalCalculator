const { test, expect } = require('@playwright/test');
test('Baseline Verification', async ({ page }) => {
    await page.goto('https://example.com');
    await expect(page.locator('h1')).toBeVisible();
});
