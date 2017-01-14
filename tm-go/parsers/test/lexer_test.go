package test_test

import (
	"testing"

	"github.com/inspirer/textmapper/tm-go/parsers/test"
	pt "github.com/inspirer/textmapper/tm-parsers/testing"
)

var lexerTests = []struct {
	tok    test.Token
	inputs []string
}{

	{test.IDENTIFIER, []string{
		`«abc» «brea» «abc-def»`,
		`«a-b-c-d»----  `,
		` «a»-`,
		` «a»--`,
		`«a»->«b»`,
		`«testfoo»----- testfoo----->`,
	}},

	{test.MINUS, []string{
		` «-» ->  a------b«-»  «-»«-»`,
	}},
	{test.MINUSGT, []string{
		`«->»`,
		`abcdef«->»`,
		`abcdef«->»   `,
		`testfoo1----«->»`,
	}},

	{test.BACKTRACKINGTOKEN, []string{
		`«test----->» «test->»  «testfoo->» testf->`,
	}},

	{test.TEST, []string{"«test»", "«test»-----"}},
	{test.DECL1, []string{"«decl1»"}},
	{test.DECL2, []string{"«decl2»"}},

	{test.LBRACE, []string{"«{»"}},
	{test.RBRACE, []string{"«}»"}},
	{test.LPAREN, []string{"«(»"}},
	{test.RPAREN, []string{"«)»"}},
	{test.LBRACK, []string{"«[»"}},
	{test.RBRACK, []string{"«]»"}},
	{test.DOT, []string{"«.»"}},
	{test.COMMA, []string{"«,»"}},
	{test.COLON, []string{"«:»"}},

	{test.SINGLELINECOMMENT, []string{" «//abc»\r\n "}},
	{test.MULTILINECOMMENT, []string{" «/**/» «/***/» «/*\r\n*/» "}},
	{test.INVALID_TOKEN, []string{" «#» "}},
}

func TestLexer(t *testing.T) {
	l := new(test.Lexer)
	seen := map[test.Token]bool{}
	seen[test.WHITESPACE] = true
	seen[test.ERROR] = true
	for _, tc := range lexerTests {
		seen[tc.tok] = true
		for _, input := range tc.inputs {
			ptest := pt.NewParserTest(tc.tok.String(), input, t)
			l.Init(ptest.Source())
			tok := l.Next()
			for tok != test.EOI {
				if tok == tc.tok {
					ptest.Consume(l.Pos())
				}
				tok = l.Next()
			}
			ptest.Done(true)
		}
	}
	for tok := test.EOI + 1; tok < test.NumTokens; tok++ {
		if !seen[tok] {
			t.Errorf("%v is not tested", tok)
		}
	}
}
