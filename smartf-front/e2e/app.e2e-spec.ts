import { SmartfFrontPage } from './app.po';

describe('smartf-front App', () => {
  let page: SmartfFrontPage;

  beforeEach(() => {
    page = new SmartfFrontPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
